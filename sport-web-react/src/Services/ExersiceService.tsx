import restService, {RequestType} from "./RestService.tsx";

export interface IExerciseData {
    title?: string
    locale?: string
    items?: IExerciseItemData[]
}

export interface IExerciseItemData {
    title?: string
    description?: string
    muscleGroups: string[]
    count: number
    hasCount: boolean
    repeatCount: number
    hasRepeatCount: boolean
    duration: number
    hasDuration: boolean
}

class ExerciseService {
    async getExercises(): Promise<IExerciseData> {
        return await restService.perform('exercises.json', RequestType.get)
            .then(response => response as IExerciseData)
    }
}

const exerciseService = new ExerciseService()

export default exerciseService;
