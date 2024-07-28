import React from 'react'
import {ExerciseCycle} from "../ExerciseCycle/ExerciseCycle";
import {ExerciseItem} from "../ExerciseItem/ExerciseItem";

export function ExerciseBlock({item}) {
    if (item?.cycle?.length) {
        return <ExerciseCycle item={item}/>
    } else {
        return <ExerciseItem item={item}/>
    }
}