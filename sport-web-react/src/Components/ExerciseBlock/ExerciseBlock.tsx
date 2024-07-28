import {ExerciseCycle} from "../ExerciseCycle/ExerciseCycle.tsx";
import {ExerciseItem} from "../ExerciseItem/ExerciseItem.tsx";

export function ExerciseBlock({item}) {
    if (item?.cycle?.length) {
        return <ExerciseCycle item={item}/>
    } else {
        return <ExerciseItem item={item}/>
    }
}