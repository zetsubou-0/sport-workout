import "./Exercise.scss"
import {ExerciseItem} from "../ExerciseItem/ExerciseItem.tsx";
import exerciseService, {IExerciseData} from "../../Services/ExersiceService.tsx";
import {useEffect, useState} from "react";

export function Exercise() {
    const [exercise, setExercise] = useState(null as IExerciseData)

    useEffect(() => {
        async function updateExercises() {
            const exerciseData = await exerciseService.getExercises()
            setExercise(exerciseData)
        }

        if (!exercise) {
            updateExercises()
        }
    }, [])

    return <div className={'Exercise'}>
        <h1>{exercise?.title}</h1>
        <ul className="exercise-items-block">
            {exercise?.items?.filter(item => item).map(item => <ExerciseItem item={item} />)}
        </ul>
    </div>
}
