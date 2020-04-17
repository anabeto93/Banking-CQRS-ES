# Banking APP with SpringBoot and CQRS ES

This is a simple demo project to show how to implement CQRS and ES in a banking application.

## Setup and Installation

Edit your `etc/hosts` to point to the microservices. If you are on windows, this can be found at C:\Windows\System32\drivers\etc\hosts

```bash
sudo vim /etc/hosts
```

Add the entries below:  
`192.168.99.100 accounts.banking.test www.accounts.banking.test`  
`192.168.99.100 accounts.banking.test www.accounts.banking.test`  
`192.168.99.100 accounts.banking.test www.accounts.banking.test`  
`192.168.99.100 rabbit.banking.test www.rabbit.banking.test`  
`192.168.99.100 axxon.banking.test www.axxon.banking.test`  
`192.168.99.100 discovery.banking.test www.discovery.banking.test`  

#### Kindly note that the `192.168.99.100` is the IP address of my docker-machine, for those using Windows and Mac with docker-toolbox

Copy the `.env.example` to `.env` so that the environment variables can be easily read.

```bash
cp .env.example .env
```

Change directory to the discovery server and build the container to generate the discovery snapshot first
```bash
cd discovery && docker-compose build && cd ..
```

Build all the containers before running them.

```bash
docker-compose build
```

#### You need patience and fast internet to get through this step. Takes quite a bit to build all springboot services.

```bash
docker-compose up -d
```
