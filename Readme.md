# Banking APP with SpringBoot and CQRS ES

This is a simple demo project to show how to implement CQRS and ES in a banking application.

## Setup and Installation

Edit your `etc/hosts` to point to the microservices. If you are on windows, this can be found at `C:\Windows\System32\drivers\etc\hosts`

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

Build each project manually first  

```bash
cd accounts && mvn -T6 clean package && cd ..  
cd config && mvn -T6 clean package && cd ..  
cd customers && mvn -T6 clean package && cd ..  
cd discovery && mvn -T6 clean package && cd ..  
cd statements && mvn -T6 clean package && cd ..  
```
#### Or if you're lazy like me, you can run all as one command

```bash
cd accounts && mvn -T6 clean package && cd .. && cd config && mvn -T6 clean package && cd ..  && cd customers && mvn -T6 clean package && cd .. && cd discovery && mvn -T6 clean package && cd ..  && cd statements && mvn -T6 clean package && cd .. 
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

One sad notice is, when you start up these applications, you have to wait a minimum of 2 minutes before you can use anyone of them.
