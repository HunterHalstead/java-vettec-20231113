import { Pipe, PipeTransform } from '@angular/core';

// a Pipe is a transformation tool for data
// you must import your custom Pipes wherever you wish to use them
@Pipe({
  name: 'stringExtender',
  standalone: true
})
export class StringExtenderPipe implements PipeTransform {

  // this method and its first value parameter are required
  // this is what will run on your data as you send it through

  // the JS rest operator looks like this   ... (three dots)
  // it collects ALL remaining parameters sent to a method
  // into a single array
  // must be the last param, because it collects all the rest

  transform(value: string, ...extensions: string[]): string {
    let extConcat: string = '';

    for (let str of extensions) {
      extConcat = extConcat + str;
    }
    
    return value + extConcat;
  }

}
