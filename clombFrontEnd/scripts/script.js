const userCreationForm = document.getElementById('user-creation-form');

let firstNameInput = document.getElementById('first-name');
let lastNameInput = document.getElementById('last-name');
let emailInput = document.getElementById('email');
let shoesInput = document.getElementById('shoes');
let chalkInput = document.getElementById('chalk');
let genderInput = document.getElementById('gender');
let usernameInput = document.getElementById('username');
let passwordInput = document.getElementById('password');


document.getElementById('fetch-users').addEventListener('click', async () => {
    try {
        const response = await fetch('http://localhost:5000/api/users');

        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }

        const users = await response.json();
        console.log('Users:', users);

        // Get the user list container
        const getObjectsList = document.getElementById('get-objects-list');
        getObjectsList.innerHTML = ''; // Clear previous entries

        users.forEach(user => {
            const li = document.createElement('li');
            const ul = document.createElement('ul');

            li.textContent = `User ID: ${user.id}`;


            const firstNameLi = document.createElement('li');
            firstNameLi.textContent = `First Name: ${user.firstName}`;

            const lastNameLi = document.createElement('li');
            lastNameLi.textContent = `Last Name: ${user.lastName}`;

            const emailLi = document.createElement('li');
            emailLi.textContent = `Email: ${user.email}`;

            // add consts for: gender, username, password, chalk, shoes, createDate, and updateDate

            const genderLi = document.createElement('li');
            genderLi.textContent = `Gender: ${user.gender}`;

            const usernameLi = document.createElement('li');
            usernameLi.textContent = `Username: ${user.username}`;

            const chalkLi = document.createElement('li');
            chalkLi.textContent = `Chalk: ${user.chalk}`;

            const shoesLi = document.createElement('li');
            shoesLi.textContent = `Shoes: ${user.shoes}`;

            const userCreateDateLi = document.createElement('li');
            userCreateDateLi.textContent = `Creation Date: ${user.userCreateDate}`;

            const userUpdateDateLi = document.createElement('li');
            userUpdateDateLi.textContent = `Update Date: ${user.userUpdateDate}`;



            ul.appendChild(firstNameLi);
            ul.appendChild(lastNameLi);
            ul.appendChild(emailLi);
            ul.appendChild(genderLi);
            ul.appendChild(usernameLi);
            ul.appendChild(chalkLi);
            ul.appendChild(shoesLi);
            ul.appendChild(userCreateDateLi);
            ul.appendChild(userUpdateDateLi);


            li.appendChild(ul);

       
            getObjectsList.appendChild(li);

            
        });


    } catch (error) {
        console.error('Error:', error.message);
        document.getElementById('get-request-error-message').textContent = "Error fetching users.";
        document.getElementById('get-request-error-message').style.color = "red";
    }
});



document.getElementById('fetch-gyms').addEventListener('click', async () => {
    try {
        const response = await fetch('http://localhost:5000/api/gyms');

        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }

        const gyms = await response.json();
        console.log('Gyms:', gyms);

        // Get the gym list container
        const getObjectsList = document.getElementById('get-objects-list');
        getObjectsList.innerHTML = ''; // Clear previous entries

        gyms.forEach(gym => {
            const li = document.createElement('li');
            const ul = document.createElement('ul');

            li.textContent = `Gym ID: ${gym.id}`;

            const gymNameLi = document.createElement('li');
            gymNameLi.textContent = `Gym Name: ${gym.gymName}`;

            const gymAddressLi = document.createElement('li');
            gymAddressLi.textContent = `Gym Address: ${gym.gymAddress}`;

            const gymCreateDateLi = document.createElement('li');
            gymCreateDateLi.textContent = `Creation Date: ${gym.gymCreateDate}`;

            const gymUpdateDateLi = document.createElement('li');
            gymUpdateDateLi.textContent = `Update Date: ${gym.gymUpdateDate}`;



            ul.appendChild(gymNameLi);
            ul.appendChild(gymAddressLi);
            ul.appendChild(gymCreateDateLi);
            ul.appendChild(gymUpdateDateLi);


            li.appendChild(ul);

       
            getObjectsList.appendChild(li);

            
        });


    } catch (error) {
        console.error('Error:', error.message);
        document.getElementById('get-request-error-message').textContent = "Error fetching gyms.";
        document.getElementById('get-request-error-message').style.color = "red";
    }
});


document.getElementById('fetch-routes').addEventListener('submit', async (event) => {
    
    event.preventDefault();
    try {
        let gymId = document.getElementById('get-route-gym-id').value;

        const response = await fetch('http://localhost:5000/api/routes/gym/'+gymId);

        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }

        const routes = await response.json();
        console.log('Routes:', routes);

        // Get the route list container
        const getObjectsList = document.getElementById('get-objects-list');
        getObjectsList.innerHTML = ''; // Clear previous entries

        routes.forEach(route => {
            const li = document.createElement('li');
            const ul = document.createElement('ul');

            li.textContent = `Route ID: ${route.id}`;

            const routeGradeLi = document.createElement('li');
            routeGradeLi.textContent = `Route Grade: ${route.grade}`;

            const routeSetterLi = document.createElement('li');
            routeSetterLi.textContent = `Route Setter: ${route.setter}`;

            const routeColorLi = document.createElement('li');
            routeColorLi.textContent = `Route Color: ${route.color}`;

            const gymIdLi = document.createElement('li');
            gymIdLi.textContent = `Gym ID: ${route.gymId}`;

            const routeCreateDateLi = document.createElement('li');
            routeCreateDateLi.textContent = `Creation Date: ${route.routeCreateDate}`;

            const routeUpdateDateLi = document.createElement('li');
            routeUpdateDateLi.textContent = `Update Date: ${route.routeUpdateDate}`;



            ul.appendChild(routeGradeLi);
            ul.appendChild(routeSetterLi);
            ul.appendChild(routeColorLi);
            ul.appendChild(gymIdLi);
            ul.appendChild(routeCreateDateLi);
            ul.appendChild(routeUpdateDateLi);


            li.appendChild(ul);

       
            getObjectsList.appendChild(li);

            
        });


    } catch (error) {
        console.error('Error:', error.message);
        document.getElementById('get-request-error-message').textContent = "Error fetching routes.";
        document.getElementById('get-request-error-message').style.color = "red";
    }
});



/* 
POST REQS START HERE
*/
userCreationForm.addEventListener('submit', async (event) => {

    event.preventDefault();
  
    let newUser = {};
    newUser.firstName = firstNameInput.value;
    newUser.lastName = lastNameInput.value;
    newUser.email = emailInput.value;
    newUser.shoes = shoesInput.value;
    newUser.chalk = chalkInput.value;
    newUser.gender = genderInput.value;
    newUser.username = usernameInput.value;
    newUser.password = passwordInput.value;

    console.log(newUser);

    try {
      const response = await fetch('http://localhost:5000/api/users', {
          method: 'POST',
          headers: {
              'Content-Type': 'application/json'
          },
          body: JSON.stringify(newUser)
      });

      if (!response.ok) {
          throw new Error(`HTTP error! Status: ${response.status}`);
      }

      const result = await response.json();
      console.log('Response:', result);

      document.getElementById('user-message').textContent = "User successfully registered!";
      document.getElementById('user-message').style.color = "green";

      // Optional: Clear form fields after successful submission
      event.target.reset();
  } catch (error) {
      console.error('Error:', error.message);
      document.getElementById('user-message').textContent = "Error submitting form. Try again.";
      document.getElementById('user-message').style.color = "red";
  }

    // output.innerHTML += '<li>'+newUser.firstName+'</li>';
    // output.innerHTML += '<li>'+newUser.lastName+'</li>';
    // output.innerHTML += '<li>'+newUser.email+'</li>';
    // output.innerHTML += '<li>'+newUser.shoes+'</li>';
    // output.innerHTML += '<li>'+newUser.chalk+'</li>';
    // output.innerHTML += '<li>'+newUser.gender+'</li>';
    // output.innerHTML += '<li>'+newUser.username+'</li>';
    // output.innerHTML += '<li>'+newUser.password+'</li>';

});


const gymCreationForm = document.getElementById('gym-creation-form');

let gymNameInput = document.getElementById('gym-name');
let gymAddressInput = document.getElementById('gym-address');


gymCreationForm.addEventListener('submit', async (event) => {

    event.preventDefault();
  
  	// output.innerHTML = "";

    let newGym = {};
    newGym.gymName = gymNameInput.value;
    newGym.gymAddress = gymAddressInput.value;

    console.log(newGym);

    try {
      const response = await fetch('http://localhost:5000/api/gyms', {
          method: 'POST',
          headers: {
              'Content-Type': 'application/json'
          },
          body: JSON.stringify(newGym)
      });

      if (!response.ok) {
          throw new Error(`HTTP error! Status: ${response.status}`);
      }

      const result = await response.json();
      console.log('Response:', result);

      document.getElementById('gym-message').textContent = "Gym successfully registered!";
      document.getElementById('gym-message').style.color = "green";

      // Optional: Clear form fields after successful submission
      event.target.reset();
  } catch (error) {
      console.error('Error:', error.message);
      document.getElementById('gym-message').textContent = "Error submitting form. Try again.";
      document.getElementById('gym-message').style.color = "red";
  }

    // output.innerHTML += '<li>'+newUser.firstName+'</li>';
    // output.innerHTML += '<li>'+newUser.lastName+'</li>';
    // output.innerHTML += '<li>'+newUser.email+'</li>';
    // output.innerHTML += '<li>'+newUser.shoes+'</li>';
    // output.innerHTML += '<li>'+newUser.chalk+'</li>';
    // output.innerHTML += '<li>'+newUser.gender+'</li>';
    // output.innerHTML += '<li>'+newUser.username+'</li>';
    // output.innerHTML += '<li>'+newUser.password+'</li>';
  });



  const routeCreationForm = document.getElementById('route-creation-form');

  let routeGradeInput = document.getElementById('route-grade');
  let routeColorInput= document.getElementById('route-color');
  let routeSetterInput = document.getElementById('route-setter');
  let gymIdInput= document.getElementById('gym-id');

    routeCreationForm.addEventListener('submit', async (event) => {

      event.preventDefault();
    
      // output.innerHTML = "";
  
      let newRoute = {};
      newRoute.grade = routeGradeInput.value;
      newRoute.setter = routeSetterInput.value;
      newRoute.color = routeColorInput.value;
      newRoute.gymId = gymIdInput.value;
  
      console.log(newRoute);
  
      try {
        const response = await fetch('http://localhost:5000/api/routes', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(newRoute)
        });
  
        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }
  
        const result = await response.json();
        console.log('Response:', result);
  
        document.getElementById('route-message').textContent = "Route successfully registered!";
        document.getElementById('route-message').style.color = "green";
  
        // Optional: Clear form fields after successful submission
        event.target.reset();
    } catch (error) {
        console.error('Error:', error.message);
        document.getElementById('route-message').textContent = "Error submitting form. Try again.";
        document.getElementById('route-message').style.color = "red";
    }
});


const climbDetailsCreationForm = document.getElementById('climbDetails-creation-form');

  let climbDetailsUserIdInput = document.getElementById('climbDetails-userId');
  let climbDetailsRouteIdInput = document.getElementById('climbDetails-routeId');
  let climbDetailsGymIdInput = document.getElementById('climbDetails-gymId');
  let climbDetailsNotesInput = document.getElementById('climbDetails-notes');
  


climbDetailsCreationForm.addEventListener('submit', async (event) => {

  event.preventDefault();

  // output.innerHTML = "";

  let newClimbDetails = {};
  newClimbDetails.userId = climbDetailsUserIdInput.value;
  newClimbDetails.routeId = climbDetailsRouteIdInput.value;
  newClimbDetails.gymId = climbDetailsGymIdInput.value;
  newClimbDetails.notes = climbDetailsNotesInput.value;

  console.log(newClimbDetails);

  try {
    const response = await fetch('http://localhost:5000/api/climbDetails', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(newClimbDetails)
    });

    if (!response.ok) {
        throw new Error(`HTTP error! Status: ${response.status}`);
    }

    const result = await response.json();
    console.log('Response:', result);

    document.getElementById('climbDetails-message').textContent = "Climb Details successfully registered!";
    document.getElementById('climbDetails-message').style.color = "green";

    // Optional: Clear form fields after successful submission
    event.target.reset();
} catch (error) {
    console.error('Error:', error.message);
    document.getElementById('climbDetails-message').textContent = "Error submitting form. Try again.";
    document.getElementById('climbDetails-message').style.color = "red";
}
});


