import { useContext } from "react";
import { Context } from "../../../../../../Context";

import styles from "./CardPatient.module.css"

export const CardPatient = () => {

  const { patient } = useContext(Context)

  return (
    <div className={styles.card}>
      <div className={styles.image_container}>
        {/* <img src="" alt="" /> */}
        <button className={styles.button}>
          Ver ficha
        </button>
      </div>

      <div className={styles.information_container}>
        <h1>
          {patient.nombre} {patient.apellido}
        </h1>

        <div className={styles.information}>
          
          <div>
            <span>
              Email:
            </span>
            <p>
              {patient.email}
            </p>
          </div>

          <div>
            <span>
              DNI:
            </span>
            <p>
              {patient.documento}
            </p>
          </div>
        </div>
      </div>
    </div>
  )
}