import { useContext } from "react"
import { useAuth } from "./security/AuthContext"

export default function FooterComponent() {
  //  const authContext = useContext(AuthContext)
      const authContext = useAuth
  console.log(`Footer component - ${authContext.number}`)
    return (
        <footer className='footer'>
            <div className='container'>
                Footer Component
            </div>
        </footer>
    )
}