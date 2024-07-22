import './ExerciseItem.scss'
import uiService from "../../Services/UIService.tsx";
import {useState} from "react";

export function ExerciseItem({item}) {

    type DataRow = {
        data: number,
        text: string,
    }

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

    function buildDataRows(data: DataRow[]) {
        return data.map(({data, text}) => {
            if (data) {
                return <div className={`exercise-data ${hiddenClass}`}>{text}: {data}</div>
            }
        })
    }

    const elClass = `exercise-item ${successClass}`
    const muscleGroups = `[${item.muscleGroups.join(', ')}]`
    const dataRows = buildDataRows([
        {data: item.count, text: 'Count'},
        {data: item.repeatCount, text: 'Repeat Count'},
        {data: item.duration, text: 'Duration'},
    ])

    return <li className={elClass} onClick={handleExerciseItem}>
        <div className="exercise-item-container">
            <h4 className="title">{item.title} {muscleGroups}<br/><br/><span
                className="description">{item.description}</span></h4>
            {dataRows}
        </div>
    </li>
}
