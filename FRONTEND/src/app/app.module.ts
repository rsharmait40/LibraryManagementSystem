import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Component } from '@angular/core';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HeaderComponent } from './header/header.component';
import { FormsModule } from '@angular/forms';
import { AddBookComponent } from './add-book/add-book.component';
import { AddUserComponent } from './add-user/add-user.component';
import { DeleteBookComponent } from './delete-book/delete-book.component';
import { DeleteUserComponent } from './delete-user/delete-user.component';
import { ShowUserComponent } from './show-user/show-user.component';
import { ShowBookComponent } from './show-book/show-book.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { SearchBookComponent } from './search-book/search-book.component';
import { BorrowBookComponent } from './borrow-book/borrow-book.component';
import { ListBookComponent } from './list-book/list-book.component';
import { HttpClientModule } from '@angular/common/http';
import { AdminComponent } from './admin/admin.component';
import { AuthGuard } from './auth.guard';
import { UserComponent } from './user/user.component'; 
import { RegisterRequestComponent } from './register-request/register-request.component';
import { ShowAllUserComponent } from './show-all-user/show-all-user.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { RequestViewComponent } from './request-view/request-view.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    RegisterComponent,
    LoginComponent,
    HeaderComponent,
    AddBookComponent,
    AddUserComponent,
    DeleteBookComponent,
    DeleteUserComponent,
    ShowUserComponent,
    ShowBookComponent,
    UpdateUserComponent,
    SearchBookComponent,
    BorrowBookComponent,
    ListBookComponent,
    AdminComponent,
    UserComponent,
    RegisterRequestComponent,
    ShowAllUserComponent,
    ForgotPasswordComponent,
    RequestViewComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      { path: 'home', component: HomeComponent, canActivate: [AuthGuard], data: { expectedRole: ['ROLE_USER'] } },
      { path: 'register', component: RegisterComponent },
      { path: 'login', component: LoginComponent },
      { path: 'add-book', component: AddBookComponent, canActivate: [AuthGuard], data: { expectedRole: ['ROLE_ADMIN'] } },
      { path: 'add-user', component: AddUserComponent, canActivate: [AuthGuard], data: { expectedRole: ['ROLE_ADMIN'] } },
      { path: 'delete-book', component: DeleteBookComponent, canActivate: [AuthGuard], data: { expectedRole: ['ROLE_ADMIN'] } },
      { path: 'delete-user', component: DeleteUserComponent, canActivate: [AuthGuard], data: { expectedRole: ['ROLE_ADMIN'] } },
      { path: 'show-book', component: ShowBookComponent, canActivate: [AuthGuard], data: { expectedRole: ['ROLE_ADMIN'] } },
      { path: 'update-user', component: UpdateUserComponent, canActivate: [AuthGuard], data: { expectedRole: ['ROLE_ADMIN'] } },
      { path: 'show-user', component: ShowUserComponent, canActivate: [AuthGuard], data: { expectedRole: ['ROLE_ADMIN'] } },
      { path: 'search', component: SearchBookComponent, canActivate: [AuthGuard], data: { expectedRole: ['ROLE_USER'] } },
      { path: 'borrow', component: BorrowBookComponent, canActivate: [AuthGuard], data: { expectedRole: ['ROLE_USER'] } },
      { path: 'getallBooks', component: ListBookComponent, canActivate: [AuthGuard], data: { expectedRole: ['ROLE_USER'] } },
      { path: 'admin', component: AdminComponent }, 
      { path: 'user', component: UserComponent},
      { path: 'forgot-password', component: ForgotPasswordComponent},
      { path: 'show-all-user', component: ShowAllUserComponent, canActivate: [AuthGuard], data: { expectedRole: ['ROLE_ADMIN'] } },
      { path: 'request-view', component: RequestViewComponent, canActivate: [AuthGuard], data: { expectedRole: ['ROLE_ADMIN'] } },
      
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
