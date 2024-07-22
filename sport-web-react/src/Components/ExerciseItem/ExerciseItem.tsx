import './ExerciseItem.scss'
import uiService from "../../Services/UIService.tsx";
import {useState} from "react";

export function ExerciseItem({item}) {

    const [hiddenClass, setHiddenClass] = useState('')
    const [successClass, setSuccessClass] = useState('')

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
