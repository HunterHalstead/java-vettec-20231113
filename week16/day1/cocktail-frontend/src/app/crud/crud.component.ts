import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-crud',
  standalone: true,
  imports: [],
  templateUrl: './crud.component.html',
  styleUrl: './crud.component.css'
})
export class CrudComponent {

  baseUrl: string = 'https://reqres.in/api/users/';

  constructor(private http: HttpClient) {
    this.getUser('2');

    this.createUser({
      'name': 'Tester McGee',
      'job': 'Testing'
    });

    this.updateUser('5', {
      'name': 'Junior Tester',
      'job': 'Testing Apprentice'
    });

    this.deleteUser('5');
  }

  // getting a single user based on ID
  // including error handling
  getUser(id: string) {
    this.http.get<any>(this.baseUrl + id, { observe: 'response' })
             .subscribe({
                // for successful responses (must use "next")
                next: data => console.log(data),
                // for error responses (must use "error")
                error: err => console.log(err),
                // to execute upon completed subscription (must use "complete")
                complete: () => console.log('GET request complete!')
             });
  }

  // creating a single user
  // POST request takes three params: URL, body, options
  createUser(user: {}) {
    this.http.post<any>(this.baseUrl, user, { observe: 'response'})
             .subscribe({
                next: data => console.log(data),
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
