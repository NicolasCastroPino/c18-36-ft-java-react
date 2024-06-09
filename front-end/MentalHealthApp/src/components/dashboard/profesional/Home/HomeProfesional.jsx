import { useContext } from "react";

import { Context } from "../../../../../Context";
import styles from "./HomeProfesional.module.css";
import { CardPatient } from "./CardPatient/CardPatient";

export const HomeProfesional = () => {
  const { professional } = useContext(Context);

  const valoration = Array.from({ length: professional.valoracion });

  return (
    <div className={styles.section}>
      <section className={styles.profile_container}>
        {/* <img src={logo} alt="logo" /> */}
        <h1>
          {professional.nombre} {professional.apellido}
        </h1>

        <div>
          <h5>
            Terapias:
          </h5>
          <span className={styles.major}>
            {professional.especialidad}
          </span>
        </div>

        <div>
          <h5>
            Valoracion:
          </h5>
          <span>
            {valoration.map((_, index) => (
              <span key={index}>⭐</span>
            ))}
          </span>
        </div>
      </section>

      <section>
        <div className={styles.divider}>
          <h1>Mis pacientes</h1>
          <hr />
        </div>
        <div className={styles.card_container}>
          <CardPatient />
        </div>
      </section>

      <section>
        <div className={styles.divider}>
          <h1>Turnos</h1>
          <hr />
        </div>
      </section>
    </div>
  );
}
