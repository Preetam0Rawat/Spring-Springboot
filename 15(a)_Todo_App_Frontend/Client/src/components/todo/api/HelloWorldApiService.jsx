import { apiClient } from "./ApiClient";


// export default function retrieveHelloWorldBean(){
//     return   apiClient.get('/hello-world-bean')
// }
// or
export const retrieveHelloWorldBean 
        = (token) => apiClient.get('/hello-world-bean', {
            // headers: {                                 //no need for this because now we using interceptors for token header
            //     Authorization : token
            // }
        })




