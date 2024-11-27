import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Profile } from '../Model/profile.type';

@Injectable({
  providedIn: 'root',
})
export class ProfileService {
  http = inject(HttpClient);

  getProfilesFromApi() {
    const url = `http://localhost:8082/api/profile`;
    return this.http.get<Array<Profile>>(url);
  }
}
