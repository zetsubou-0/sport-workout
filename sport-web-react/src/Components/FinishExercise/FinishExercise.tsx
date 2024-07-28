import React from 'react'
import "./FinishExercise.scss"

type ExerciseState = {

}

export function FinishExercise() {
    const className ='finish-exercise'
    return <div className={className}>
        <button className={`${className}-button`}>Finish</button>
    </div>
}