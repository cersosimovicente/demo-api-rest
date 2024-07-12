document.addEventListener("DOMContentLoaded", () => {


  const url = "http://localhost:8080/api/products";
  //peticion fetch

 const peticion = ()=> fetch(url, {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json'
    }
  })
  .then(response => response.json()
  .then(data => {
    console.log(data);
    let products = data;
    let html = "";
    products.forEach(product => {
      html += `
      
         <div class="col-lg-4"> 
         <h3>${product.name}</h3>
         <p>${product.price}</p>
        
      </div>
      `;
    });
    document.getElementById("products").innerHTML = html;
  })
  .catch(error => console.log(error))
  );


//call function
peticion();


// const url = "http://localhost:8080/api/products";
// const data = {
//   name: "Nuevo Producto",
//   price: 99.99,
//   description: "Descripción del nuevo producto"
// };

// fetch(url, {
//   method: 'POST', // Método HTTP a usar
//   headers: {
//     'Content-Type': 'application/json' // Especificamos que enviamos JSON
//   },
//   body: JSON.stringify(data) // Convertimos el objeto data a una cadena JSON
// })
// .then(response => {
//   if (!response.ok) {
//     throw new Error('Network response was not ok ' + response.statusText);
//   }
//   return response.json(); // Convertimos la respuesta a JSON
// })
// .then(data => {
//   console.log('Success:', data); // Aquí manejamos la respuesta de la API
// })
// .catch(error => {
//   console.error('There was a problem with the fetch operation:', error);
// });




});