// Promises are an object that represent a value which may be available now, or in the future, or never.

/*
Promise States:
- Pending
- Fulfilled = operation completed successfully
- Rejected = operation failed
*/

// The fetch API returns a Promise so we need to know how to use them

/*
Given a Promise, you chain on methods containing callback methods

myPromise.then((result) -> { // do stuff with result })
         .catch((error) => { // do stuff with error })
*/

/*
You can chain .then() so each callback waits for the previous callback to run


myPromise.then((result) -> { // do stuff with result })
         .then((data) -> { // do stuff with data })
         .catch((error) => { // do stuff with error })

*/