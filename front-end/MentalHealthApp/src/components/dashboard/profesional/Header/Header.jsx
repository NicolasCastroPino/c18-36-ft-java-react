import { useContext } from "react";
import { Context } from "../../../../../Context";

import styles from "./Header.module.css"

export const Header = () => {

  // const { authState } = useContext(Context);

  // const valoration = Array.from({ length: authState.valoracion });
  

  return (
    <section className={styles.profile_container}>
    {/* <img src={logo} alt="logo" /> */}
    <h1>
      name
    </h1>

    <div>
      <h5>
        Terapias:
      </h5>
      <span className={styles.major}>
        especial
      </span>
    </div>

    <div>
      <h5>
        Valoracion:
      </h5>
      {/* <span>
        {valoration.map((_, index) => (
          <span key={index}>⭐</span>
        ))}
      </span> */}
    </div>
  </section>
  )
}