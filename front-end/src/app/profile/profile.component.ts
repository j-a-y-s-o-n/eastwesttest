import { Component, inject, signal } from '@angular/core';
import { ProfileService } from '../services/profile.service';
import { Profile } from '../Model/profile.type';
import { catchError } from 'rxjs';
import { ProfileItemComponent } from '../component/profile-item/profile-item.component';
import { FilterProfilePipe } from '../pipes/filter-profile.pipe';

@Component({
  selector: 'app-profile',
  imports: [ProfileItemComponent, FilterProfilePipe],
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css',
})
export class ProfileComponent {
  profileService = inject(ProfileService);
  profileItems = signal<Array<Profile>>([]);
  searchTerm = signal('');

  ngOnInit(): void {
    this.profileService
      .getProfilesFromApi()
      .pipe(
        catchError((err) => {
          console.log(err);
          throw err;
        })
      )
      .subscribe((profiles) => {
        this.profileItems.set(profiles);
      });
  }
}
