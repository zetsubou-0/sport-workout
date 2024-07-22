import './ExerciseItem.scss'
import {useEffect, useState} from "react";

export function ExerciseItem({item}) {

    const [hiddenClass, setHiddenClass] = useState('')
    const [successClass, setSuccessClass] = useState('')

    function handleExerciseItem() {
        switchClass({
            getFn: hiddenClass,
            setFn: setHiddenClass,
            switchStateClass: 'hidden',
        })
        switchClass({
            getFn: successClass,
            setFn: setSuccessClass,
            switchStateClass: 'success'
        })
    }

    function switchClass({getFn, setFn, defaultStateClass = '', switchStateClass = ''}) {
        if (getFn === switchStateClass) {
            setFn(defaultStateClass)
        } else {
            setFn(switchStateClass)
        }
    }

    function buildDataRow(data: number, text: string) {
        if (data) {
            return <div className={`exercise-data ${hiddenClass}`}>{text}: {data}</div>
        }
    }

    const count = buildDataRow(item.count, 'Count')
    const repeatCount = buildDataRow(item.repeatCount, 'Repeat Count')
    const duration = buildDataRow(item.duration, 'Duration')
    const elClass = `exercise-item ${successClass}`
    const muscleGroups = `[${item.muscleGroups.join(', ')}]`

    return <li className={elClass} onClick={handleExerciseItem}>
        <div className="exercise-item-container">
            <h4 className="title">{item.title} {muscleGroups}<br/><br/><span
                className="description">{item.description}</span></h4>
            {count}
            {repeatCount}
            {duration}
        </div>
    </li>
}
