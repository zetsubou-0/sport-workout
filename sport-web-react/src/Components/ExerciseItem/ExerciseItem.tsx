import './ExerciseItem.scss'
import uiService from "../../Services/UIService.tsx";
import {useState} from "react";

export function ExerciseItem({item}) {

    type DataRow = {
        data: number,
        text: string,
    }

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
        {data: item.repeatCount, text: 'Repeat Count'},
        {data: item.duration, text: 'Duration'},
    ]

    const elClass = `exercise-item ${successClass}`
    const muscleGroups = `[${item.muscleGroups.join(', ')}]`

    return <li className={elClass} onClick={handleExerciseItem}>
        <div className="exercise-item-container">
            <h4 className="title">{item.title} {muscleGroups}<br/><br/><span
                className="description">{item.description}</span></h4>
            {dataRowsInfo.map(({data, text}) => {
                if (data) {
                    return (<div className={`exercise-data ${hiddenClass}`}>{text}: {data}</div>)
                }
            })}
        </div>
    </li>
}
