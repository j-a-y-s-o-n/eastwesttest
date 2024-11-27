import { Component, inject, input } from '@angular/core';
import { Profile } from '../../Model/profile.type';

@Component({
  selector: 'app-profile-item',
  imports: [],
  templateUrl: './profile-item.component.html',
  styleUrl: './profile-item.component.css',
})
export class ProfileItemComponent {
  item = input.required<Profile>();
}
