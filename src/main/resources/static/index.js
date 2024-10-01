function openAddProperty() {
    const form = document.getElementById('propertyForm');
    if (form.style.display === 'none' || form.style.display === '') {
        form.style.display = 'block';
    } else {
        form.style.display = 'none';
    }
}

document.getElementById('addButton').addEventListener('click', openAddProperty);

async function addProperty(event) {
    event.preventDefault();
    const address = document.getElementById('address').value;
    const price = parseFloat(document.getElementById('price').value);
    const size = parseFloat(document.getElementById('size').value);
    const description = document.getElementById('description').value;

    const property = {
        address: address,
        price: price,
        size: size,
        description: description
    };

    try {
        const response = await fetch('/properties/create', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(property)
        });

        if (response.ok) {
            document.getElementById('propertyForm').reset();
            document.getElementById('propertyForm').style.display = 'none';
            fetchProperties();
        } else {
            console.error('Error al crear la propiedad:', response.statusText);
        }
    } catch (error) {
        console.error('Error al realizar la petición:', error);
    }
}

async function fetchProperties() {
    try {
        const response = await fetch('/properties');
        if (response.ok) {
            const properties = await response.json();
            displayProperties(properties);
        } else {
            console.error('Error al obtener propiedades:', response.statusText);
        }
    } catch (error) {
        console.error('Error al realizar la petición:', error);
    }
}

function displayProperties(properties) {
    const propertyList = document.getElementById('propertyList');
    propertyList.innerHTML = '';

    properties.forEach(property => {
        const li = document.createElement('li');
        li.classList.add('property-item');
        li.textContent = `${property.address} - Precio: $${property.price} - Tamaño: ${property.size} m² - Descripción: ${property.description}`;
        propertyList.appendChild(li);
    });
}

window.onload = fetchProperties;
