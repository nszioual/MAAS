import { Component, OnInit, Output, Input, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-login-modal',
  templateUrl: './login-modal.component.html',
  styleUrls: ['./login-modal.component.css'],
})
export class LoginModalComponent implements OnInit {
  @Input()
  GitHubUserName = '';
  GitHubPassWord = '';

  @Output()
  onClose = new EventEmitter();

  constructor() {}

  ngOnInit(): void {}

  cancel() {
    this.onClose.emit(null);
  }

  login() {
    this.onClose.emit({ userName: this.GitHubUserName, passWord: this.GitHubPassWord});
  }
}
