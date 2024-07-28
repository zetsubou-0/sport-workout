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
    repeatCount: number
    duration: number
    cycle?: IExerciseItemData[]
}

class ExerciseService {
    async getExercises(name: string, counter: string): Promise<IExerciseData> {
        return await restService.perform(`exercises/${name}.json?counter=${counter}`, RequestType.get)
            .then(response => response as IExerciseData)
    }

    getSearchParam(key: string): string {
        return new URLSearchParams(document.location.search).get(key)
    }
}

const exerciseService = new ExerciseService()

export default exerciseService;
