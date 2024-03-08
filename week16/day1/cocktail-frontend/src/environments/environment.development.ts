// this environment (env) file contains properties we can use throughout
// they are "baked in" at build time
// changing them while running the app changes nothing
// you have to reboot the app to get updates from here

// to serve a specific environment => ng serve --configuration=<env name>
// check angular.json > configurations > development > file replacements
// for which files will be used when running in a particular env
export const environment = {
    production: false,
    apiURL: 'https://www.thecocktaildb.com/api/json/v1/1/'
};
