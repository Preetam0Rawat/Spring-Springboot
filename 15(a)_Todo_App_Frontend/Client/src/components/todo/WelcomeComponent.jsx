import { Link, useParams } from "react-router-dom"
import {retrieveHelloWorldBean} from "./api/HelloWorldApiService"
import { useAuth } from "./security/AuthContext"
export default function WelcomeComponent() {
    const { username } = useParams()

    const authContext = useAuth()

    function callHelloWorldRestApi() {
        retrieveHelloWorldBean(authContext.token)
            .then((response) => sucessfulResponse(response))
            .catch((error) => errorResponse(error))
            .finally(() => console.log('cleanup'))
    }

    function sucessfulResponse(response) {
        console.log(response)
    }


    function errorResponse(error) {
        console.log(error)
    }

    return (
        <div className='WelcomeComponent'>
            <h1> Welcome {username}</h1>
            <div>
                Your Todos. <Link to='/todos'>Go here</Link>
            </div>
            <div>
                <button className="btn btn-success" onClick={callHelloWorldRestApi}>Call Hello World</button>
            </div>
        </div>
    )
}