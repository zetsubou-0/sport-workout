import React from 'react'
import "./ExerciseCycle.scss"
import {ExerciseItem} from "../ExerciseItem/ExerciseItem";

export function ExerciseCycle({item}) {
    const repeatCount = item?.repeatCount > 1 ? <h3 className={"exercise-cycle-repeat-count"}>Repeat {item?.repeatCount} times</h3> : undefined;
    return <li className={"exercise-cycle"}>
        <ul className={"exercise-cycle-block"}>
            {repeatCount}
            {item?.cycle?.map(cycleItem => <ExerciseItem item={cycleItem}/>)}
        </ul>
    </li>
}