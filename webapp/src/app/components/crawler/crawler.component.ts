import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CrawlerService } from '../../services/crawler.service';
import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';

@Component({
  selector: 'app-crawler',
  templateUrl: './crawler.component.html',
  styleUrls: ['./crawler.component.css']
})
export class CrawlerComponent implements OnInit {
  submitted = false;
  searchForm: FormGroup;

  extensions: any = ['bpmn', 'epml'];
  status: any = 'idle';
  collectedModels = 0;
  nonValidModels = 0;
  totalLinksCount = 0;

  webSocketEndPoint = 'http://localhost:8888/socket';
  stompClient: any;

  constructor(
    public fb: FormBuilder,
    private crawlerService: CrawlerService
  ) {
  }

  ngOnInit(): void {
    this.searchForm = this.fb.group({
      userName: ['', []],
      passWord: ['', []],
      extension: ['', []]
    });
    this.getCrawlerStatus();
  }

  changeExtension(e): void {
    console.log(e.value);
    this.extension.setValue(e.target.value, {
      onlySelf: true
    });
  }

  updateStatus(): void {
    this.getCrawlerStatus();
  }

  connect(): void {
    const socket = new SockJS(this.webSocketEndPoint);
    this.stompClient = Stomp.over(socket);
    const self = this;
    this.stompClient.connect({}, (frame) => {
      console.log('Connected: ' + frame);
      self.stompClient.subscribe('message/stats', (data) => {
        console.log(data.body);
      });
    });
  }

  getCrawlerStatus(): void {
    this.crawlerService.getCrawlerStatus().subscribe(
      (data) => {
        this.status = data.status;
        this.collectedModels = data.collectedModels;
        this.nonValidModels = data.nonValidModels;
        this.totalLinksCount = data.totalLinksCount;
        console.log(data);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  get extension(): any {
    return this.searchForm.get('extension');
  }

  startCrawler(): any {
    this.submitted = true;
    if (!this.searchForm.valid) {
      return false;
    } else {
      this.crawlerService.startCrawlerWithOptions(this.searchForm.value).subscribe(
        (data) => {
          this.status = data.status;
          console.log(data);
        },
        (error) => {
          console.log(error);
        }
      );
    }
  }

  stopCrawler(): void {
    this.crawlerService.stopCrawler().subscribe(
      (data) => {
        this.status = data.status;
        console.log(data);
      },
      (error) => {
        console.log(error);
      }
    );
  }
}
