import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, Validators, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-crud',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './crud.component.html',
  styleUrl: './crud.component.css'
})
export class CrudComponent {

  baseUrl: string = 'https://reqres.in/api/users/';

  constructor(private http: HttpClient, private fb: FormBuilder) {
    
    this.updateUser('5', {
      'name': 'Junior Tester',
      'job': 'Testing Apprentice'
    });

    this.deleteUser('5');
  }

  // creates a form group
  // takes in an object containing one field per property
  // property array params: initial value, validators (1 or more)
  getFormGroup = this.fb.group({
    getId: ['', Validators.required]
  });

  // getter method for getId property
  get getId() {
    return this.getFormGroup.get('getId');
  }

  // a form group for our POST request
  postFormGroup = this.fb.group({
    postName: ['', Validators.compose([Validators.required,
                                       Validators.minLength(5),
                                       Validators.maxLength(20)])],
    postJob: ['', Validators.compose([Validators.required,
                                       Validators.minLength(10),
                                       Validators.maxLength(25)])],                                                                
  });

  get postName() {
    return this.postFormGroup.get('postName');
  }

  get postJob() {
    return this.postFormGroup.get('postJob');
  }








  user = {
    id: 123,
    avatar: 'https://reqres.in/img/faces/2-image.jpg',
    email: 'abc@123.com',
    first_name: 'Tester',
    last_name: 'McGee'
  };

  // getting a single user based on ID
  // including error handling
  getUser(id: string) {
    this.http.get<any>(this.baseUrl + id, { observe: 'response' })
             .subscribe({
                // for successful responses (must use "next")
                next: data => this.user = data.body.data,
                // for error responses (must use "error")
                error: err => console.log(err),
                // to execute upon completed subscription (must use "complete")
                complete: () => console.log('GET request complete!')
             });
  }


  postUser = {
    id: 123,
    name: 'Tester McGee 2',
    job: 'Junior Tester',
    createdAt: 'Yesterday'
  }

  // creating a single user
  // POST request takes three params: URL, body, options
  createUser(user: {}) {
    this.http.post<any>(this.baseUrl, user, { observe: 'response'})
             .subscribe({
                next: data => this.postUser = data.body,
                error: err => console.log(err),
                complete: () => console.log('POST request complete!')
   });
  }

  // updating a single user
  // also three params: URL, body, options
  updateUser(id: string, user: {}) {
    this.http.put<any>(this.baseUrl + id, user, { observe: 'response'})
             .subscribe({
                next: data => console.log(data),
                error: err => console.log(err),
                complete: () => console.log('PUT request complete!')
   });
  }

  // deleting a single user
  // two params: URL, options
  // if you wish to include a body object
  // you may do so in the options block -- { body: {} }
  deleteUser(id: string) {
    this.http.delete<any>(this.baseUrl + id, { observe: 'response' })
             .subscribe({
                next: data => console.log(data),
                error: err => console.log(err),
                complete: () => console.log('DELETE request complete!')
   });
  }
}
