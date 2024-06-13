import React from "react";
import "./DailyEmotions.css"
import EmotionCard from "../emotionCard/EmotionCard"

const DailyEmotions = ()=>{
    return(
        <div className="daily-container">
            <div className="daily-title-button">
                <h2 className='title-home'>Diario de emociones</h2>
                <button className="button-daily" onClick={() => { /* hagregar emotion */ }}>Agregar emoción</button>

            </div>
           
            <div className="emotions-part">
            <EmotionCard></EmotionCard> 
            <EmotionCard></EmotionCard> 
            <EmotionCard></EmotionCard> 
            <EmotionCard></EmotionCard> 


            </div>
            

        </div>
    )
}

export default DailyEmotions