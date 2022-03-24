let data = []
const state = {
    pickupsOpen: null
}

fetch("/guitars/")
    .then(response => response.json())
    .then(_data => {
        data = _data
        render()
    })
    .catch(err => console.error(err))

function getAddFormHtml() {
    return `
        

    `
}

function render() {
    let content = data.map((guitarData, i) => {
        return `
            <article id="article">
                <image id="data_images"src="${guitarData.image}" alt="${guitarData.name}"/>
                <h2>${guitarData.name}</h2>
                <button id="data_buttons" onclick="displayPickups(${i})">Show Pickup Configuration ⚡️</button>
                
            </article>
        `

    }).join("")

    content += getAddFormHtml()

    const appEl = document.getElementById('ViewGuitars')
    console.log(appEl)
    appEl.innerHTML = content

    if (state.pickupsOpen) {
        const modalContent = `
            <section class="modal-bg">
                <article>
                    ${state.pickupsOpen.map(pickups => {
                        return `<h3>${pickups.name}</h3>`
                }).join("")}
                    <button onclick="closeModal()">X</button>
                </article>
            </section>
        `

        const modalEl = document.getElementById('modal')
        modalEl.innerHTML = modalContent
    } else {
        const modalEl =  document.getElementById("modal")
        modalEl.innerHTML = ""
    }
}

function displayPickups(index) {
    state.pickupsOpen = data[index].pickups
    render()
}

function closeModal() {
    state.pickupsOpen = null
    render()
}