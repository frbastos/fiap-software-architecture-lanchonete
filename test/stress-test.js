import http from 'k6/http';

export const options = {
    vus: 150, //nº de usuários
    duration: '120s',
    thresholds: {
        http_req_failed: ['rate<0.01'], // http errors deve ser menor do que 1%
        http_req_duration: ['p(95)<1'] // 95% das requisições devem estar abaixo de 1s
    },
};

export default function () {
    let data = {
        "description": "X-Salada",
        "price": 20.0,
        "category": "DESSERT"
    }
   // http.get('http://localhost:31000/products');
    http.post('http://localhost:31000/products', JSON.stringify(data), {
        headers: {'Content-Type': 'application/json'}
    });
}