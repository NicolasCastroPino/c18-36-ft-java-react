import { Link } from "react-router-dom"

export const Home = () => {
  return (
    <>
      <h1>Hello World</h1>
      <Link to="login">
        Login 
      </Link>
    </>
  )
}