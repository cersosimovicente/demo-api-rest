const url = "http://localhost:8080/api/products";

document.addEventListener("DOMContentLoaded", () => {
  loadData();
});




const loadData = async () => {
  try {
    const res = await fetch(url);
    if (res.ok) {
      const data = await res.json();
      console.log(data);
      showData(data); // Uncomment if showData is defined elsewhere
    }else{
        console.log(`Error: ${res.statusText}`);
    }
  } catch (error) {
    console.log(error);
  }
};


const showData = (data) => {
    const container = document.getElementById('products');
    data.forEach(product => {
        
        container.innerHTML += `
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                
            </tr>
        `;
    });
};
