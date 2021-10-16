import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CrawlerService } from '../../services/crawler.service';
import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';
import { interval, Subscription } from 'rxjs';
import { AppConstants } from 'src/app/commons/app-constants';

@Component({
  selector: 'app-crawler',
  templateUrl: './crawler.component.html',
  styleUrls: ['./crawler.component.css'],
})
export class CrawlerComponent implements OnInit {
  submitted = false;
  searchForm: FormGroup;
  showLoginModal = false;
  isSelected = false;

  extensions: any = ['bpmn', 'epml'];
  status: any = 'offline';
  collectedModels = 0;
  nonValidModels = 0;
  totalLinksCount = 0;

  stompClient: any;
  subscription: Subscription;

  constructor(public fb: FormBuilder, private crawlerService: CrawlerService) {}

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  ngOnInit(): void {
    this.searchForm = this.fb.group({
      userName: ['', []],
      passWord: ['', []],
      extension: ['', []],
    });
    this.connect();
    this.subscription = interval(2000).subscribe(() => this.getStatus());
  }

  changeExtension(e): void {
    if (this.extension.value === '') {
      this.isSelected = false;
    } else {
      this.isSelected = true;
    }
  }

  connect(): void {
    const self = this;
    const socket = new SockJS(AppConstants.SOCKET_ENDPOINT);
    this.stompClient = Stomp.over(socket);
    this.stompClient.connect(
      {},
      (frame) => {
        console.log('Connected: ' + frame);
        self.stompClient.subscribe('/topic/messages', (data) => {
          self.updateStatus(JSON.parse(data.body));
        });
      },
      () => {
        this.status = 'offline';
      }
    );
  }

  getStatus(): void {
    this.stompClient.send('/app/stats', {}, 'get');
  }

  updateStatus(outputData): void {
    this.totalLinksCount = outputData.totalLinksCount;
    this.collectedModels = outputData.collectedModels;
    this.nonValidModels = outputData.nonValidModels;
    this.status = outputData.crawlerStatus;
  }

  get extension(): any {
    return this.searchForm.get('extension');
  }

  startCrawler(): any {
    this.submitted = true;
    if (!this.searchForm.valid) {
      return false;
    } else {
      this.showLoginModal = true;
    }
  }

  startCrawlerWithUser(user): any {
    this.showLoginModal = false;
    if (user) {
      this.searchForm.controls['userName'].setValue(user.userName);
      this.searchForm.controls['passWord'].setValue(user.passWord);
      this.crawlerService
        .startCrawlerWithOptions(this.searchForm.value)
        .subscribe(
          (data) => {
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
        console.log(data);
      },
      (error) => {
        console.log(error);
      }
    );
  }
}
