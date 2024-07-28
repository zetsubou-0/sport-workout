import React from 'react'
import "./Exercise.scss"
import exerciseService, {IExerciseData} from "../../Services/ExersiceService";
import restService from "../../Services/RestService";
import {useEffect, useState} from "react";
import {ExerciseBlock} from "../ExerciseBlock/ExerciseBlock";
import {FinishExercise} from "../FinishExercise/FinishExercise";

export function Exercise() {
    const [exercise, setExercise] = useState(null as IExerciseData)

    useEffect(() => {
        async function updateExercises() {
            const exerciseName = restService.getSearchParam('exerciseName')
            const counter = restService.getSearchParam('counter')
            const exerciseData = await exerciseService.getExercises(exerciseName, counter)
            setExercise(exerciseData)
        }

        if (!exercise) {
            updateExercises()
        }
    }, [])

    return <div className={'Exercise'}>
        <h1>{exercise?.title}</h1>
        <ul className="exercise-items-block">
            {exercise?.items?.filter(item => item).map(item => <ExerciseBlock item={item} />)}
        </ul>
        <FinishExercise/>
    </div>
}
