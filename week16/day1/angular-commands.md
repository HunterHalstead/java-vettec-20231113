#ANGULAR COMMANDS

ng new <project name> -- create a new project
- will create its own repo if you're outside of one
- if inside one already, it doesn't
- if downloading someone else's project from a repo, you have to run npm i / npm install

ng serve / ng s -- start your project and serve it to a browser
- localhost:4200
- add --open to auto-open a browser window to that location
- add --live-reload to ensure that your changes, when saved, automatically update in the app

ng generate / ng g -- create an element of some kind in your application
- component, class, service, etc.
- example: ng g component Footer
- example: ng generate service http
- creates all files necessary for that element, plus some routing

ng test -- runs your test files for all the components