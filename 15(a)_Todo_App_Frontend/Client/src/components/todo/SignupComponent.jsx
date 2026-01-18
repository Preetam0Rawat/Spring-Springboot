import React, { useState } from "react"
import { executeSignupService } from "./api/AuthenticationApiService"
import { useNavigate } from "react-router-dom"

export default function SignupComponent() {

  const [username, setUsername] = useState("")
  const [password, setPassword] = useState("")

  const [message, setMessage] = useState("")
  const [error, setError] = useState("")

  const navigate = useNavigate()

  async function handleSignup(e) {
    e.preventDefault()

    setMessage("")
    setError("")

    try {
      const response = await executeSignupService(username, password)

      setMessage(response.data) // "Signup successful"
      navigate("/login")

    } catch (err) {
      // backend returns "Username already exists"
      if (err.response) {
        setUsername("")
        setPassword("")
        setError(err.response.data)
      } else {
        setError("Something went wrong. Backend not running?")
      }
    }
  }

  return (
    <div style={{ maxWidth: "400px", margin: "50px auto" }}>
      <h2>Signup</h2>

      {message && <p style={{ color: "green" }}>{message}</p>}
      {error && <p style={{ color: "red" }}>{error}</p>}

      <form onSubmit={handleSignup}>
        <div style={{ marginBottom: "10px" }}>
          <label>Username</label>
          <input
            type="text"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            placeholder="Enter username"
            required
            style={{ width: "100%", padding: "8px" }}
          />
        </div>

        <div style={{ marginBottom: "10px" }}>
          <label>Password</label>
          <input
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            placeholder="Enter password"
            required
            style={{ width: "100%", padding: "8px" }}
          />
        </div>

        <button type="submit" style={{ padding: "10px", width: "100%" }}>
          Signup
        </button>
      </form>
    </div>
  )
}
