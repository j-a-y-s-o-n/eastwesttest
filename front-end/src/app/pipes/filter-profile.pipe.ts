import { Pipe, PipeTransform } from '@angular/core';
import { Profile } from '../Model/profile.type';

@Pipe({
  name: 'filterProfile',
})
export class FilterProfilePipe implements PipeTransform {
  transform(profiles: Profile[], searchTerm: string): Profile[] {
    if (!searchTerm) {
      return profiles;
    }
    const text = searchTerm.toLowerCase();
    return profiles.filter((todo) => {
      return todo.fname.toLowerCase().includes(text);
    });
  }
}
