class UIService {
    switchClass({stateHandler = [], defaultStateClass = '', switchStateClass = ''})  {
        const [getFn, setFn] = stateHandler
        if (getFn === switchStateClass) {
            setFn(defaultStateClass)
        } else {
            setFn(switchStateClass)
        }
    }
}

const uiService = new UIService()

export default uiService;