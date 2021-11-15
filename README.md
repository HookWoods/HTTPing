<div id="top"></div>

[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]

<br />
<div align="center">
<h3 align="center">HTTP Ping Application</h3>

  <p align="center">
    Small project to get the status of a website.
    <br />
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

This project is a small project to get the status of a website.
I created this project to test the Spring WebFlux api.
If you want to use it or modify the project, do it as you want.
<p align="right">(<a href="#top">back to top</a>)</p>



### Built With

* [Reactive Spring](https://spring.io/reactive)
* [Thymeleaf](https://www.thymeleaf.org/)
* [MongoDB](https://www.mongodb.com//)
* [Caffeine](https://github.com/ben-manes/caffeine)
* [Bootstrap](https://getbootstrap.com/)
<p align="right">(<a href="#top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

This is an example of how you may give instructions on setting up this project locally.
To get a local copy up and running follow these simple example steps.

### Prerequisites

You will need to have a local MongoDB instance running.
You will also need to have JDK 11+ installed.
And finally you will need gradle to build the project

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/HookWoods/HTTPing.git
   ```
2. Modify the src/main/resources/application.yml file to point to your local MongoDB instance
   ```properties
   spring.data.mongodb.uri=mongodb+srv://USER:PASS@URL/DATABASE
   spring.data.mongodb.database=COLLECTION
   ```
3. Modify the application port if you need in the src/main/resources/application.yml file
   ```properties
   server.port=8001
   ```
4. Build the project 
   ```sh
   gradle build
   ```
5. Run the application
   ```sh
   java -jar build/libs/httping-1.0.jar
   ```

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- LICENSE -->
## License

Distributed under the GNU General Public License v3.0. See `LICENSE` for more information.

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- CONTACT -->
## Contact

Hugo Planque - [@HookWood_](https://twitter.com/HookWood_) - hookwood01@gmail.com

Project Link: [https://github.com/HookWoods/HTTPing](https://github.com/HookWoods/HTTPing)

<p align="right">(<a href="#top">back to top</a>)</p>

[contributors-shield]: https://img.shields.io/github/contributors/HookWoods/httping.svg?style=for-the-badge
[contributors-url]: https://github.com/HookWoods/HTTPing/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/HookWoods/httping.svg?style=for-the-badge
[forks-url]: https://github.com/HookWoods/HTTPing/network/members
[stars-shield]: https://img.shields.io/github/stars/HookWoods/httping.svg?style=for-the-badge
[stars-url]: https://github.com/HookWoods/HTTPing/stargazers
[issues-shield]: https://img.shields.io/github/issues/HookWoods/httping.svg?style=for-the-badge
[issues-url]: https://github.com/HookWoods/HTTPing/issues
[license-shield]: https://img.shields.io/github/license/HookWoods/httping.svg?style=for-the-badge
[license-url]: https://github.com/HookWoods/HTTPing/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/hugo-planque-812888171/