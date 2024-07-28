const baseUrl = 'http://localhost:8080'

export enum RequestType {
    get = 'GET',
    post = 'POST',
    put = 'PUT',
    delete = 'DELETE',
}

class RestService {
    async perform(url: string, type = RequestType.get, body?: any ) {
        return fetch(`${baseUrl}/${url}`, this.buildHeaders(type, body))
            .then(response => response.json())
    }

    getSearchParam(key: string): string {
        return new URLSearchParams(document.location.search).get(key)
    }


    private buildHeaders(type: RequestType, body?: any) {
        return {
            method: type,
            headers: { 'Content-Type': 'application/json' },
            body: body && JSON.stringify(body) || undefined,
        }
    }
}

const restService = new RestService()

export default restService;
