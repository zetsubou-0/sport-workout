import React from 'react'
import './ExerciseItem.scss'
import uiService from "../../Services/UIService";
import {useState} from "react";

export function ExerciseItem({item}) {

    function handleExerciseItem() {
        uiService.switchClass({
            stateHandler: [hiddenClass, setHiddenClass],
            switchStateClass: 'hidden',
        })
        uiService.switchClass({
            stateHandler: [successClass, setSuccessClass],
            switchStateClass: 'success'
        })
    }

    const [hiddenClass, setHiddenClass] = useState('')
    const [successClass, setSuccessClass] = useState('')

    const dataRowsInfo = [
        {data: item.count, text: 'Count'},
        {data: item.repeatCount, text: 'Repeat Count', postfix: 'times'},
        {data: item.duration, text: 'Duration', postfix: 'sec'},
    ]

    const elClass = `exercise-item ${successClass}`
    const muscleGroups = `[${item.muscleGroups.join(', ')}]`

    return <li className={elClass} onClick={handleExerciseItem}>
        <div className="exercise-item-container">
            <h4 className="exercise-item-title">{item.title} {muscleGroups}</h4>
            <div className="exercise-item-description">{item.description}</div>
            {dataRowsInfo.map(({data, text, postfix}) => {
                if (data) {
                    return (<div className={`exercise-data ${hiddenClass}`}>{text}: {data} {postfix}</div>)
                }
            })}
        </div>
    </li>
}
