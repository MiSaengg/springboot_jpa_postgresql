## AWS EC2

### Cost
- EC2: https://aws.amazon.com/ec2/pricing/on-demand/
- RDS: https://aws.amazon.com/rds/postgresql/pricing/

### What is AWS EC2?
AWS EC2 (Amazon Elastic Compute Cloud) is a web service that provides resizable compute capacity in the cloud. It is designed to make web-scale cloud computing easier for developers. It provides you with complete control of your computing resources and lets you run on Amazon’s proven computing environment.

TLDR: It's a virtual machine in the cloud. Cloud computing. 

### Features of EC2
- Virtual computing environments, known as instances
- Preconfigured templates for your instances, known as Amazon Machine Images (AMIs), that package the bits you need for your server (including the operating system and additional software)
- Various configurations of CPU, memory, storage, and networking capacity for your instances, known as instance types
- Secure login information for your instances using key pairs (AWS stores the public key, and you store the private key in a secure place)
- Storage volumes for temporary data that's deleted when you stop or terminate your instance, known as instance store volumes
- Persistent storage volumes for your data using Amazon Elastic Block Store (Amazon EBS), known as Amazon EBS volumes
- Multiple physical locations for your resources, such as instances and Amazon EBS volumes, known as regions and Availability Zones
- A firewall that enables you to specify the protocols, ports, and source IP ranges that can reach your instances using security groups
- Static IPv4 addresses for dynamic cloud computing, known as Elastic IP addresses
- Metadata, known as tags, that you can create and assign to your Amazon EC2 resources
- Virtual networks you can create that are logically isolated from the rest of the AWS cloud, and that you can optionally connect to your own network, known as virtual private clouds (VPCs)
List here: https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/concepts.html#concepts-features

### What is an EC2 Instance?
An EC2 instance is a virtual server in Amazon's Elastic Compute Cloud (EC2) for running applications on the Amazon Web Services (AWS) infrastructure. AWS is a comprehensive, evolving cloud computing platform; EC2 is a service that allows business subscribers to run application programs in the computing environment.

### What is an EC2 Instance Type?
Amazon EC2 provides a wide selection of instance types optimized to fit different use cases. Instance types comprise varying combinations of CPU, memory, storage, and networking capacity and give you the flexibility to choose the appropriate mix of resources for your applications. Each instance type includes one or more instance sizes, allowing you to scale your resources to the requirements of your target workload.

### What is an EC2 AMI?
An Amazon Machine Image (AMI) provides the information required to launch an instance. You must specify an AMI when you launch an instance. You can launch multiple instances from a single AMI when you need multiple instances with the same configuration. You can use different AMIs to launch instances when you need instances with different configurations.

### Setting up AWS EC2 with PostgreSQL
1. Create an AWS account
2. Create an EC2 instance
    2.1 Select an AMI
    2.2 Choose an Instance Type
    2.3 Configure Instance Details
    2.4 Add Storage
    2.5 Add Tags
    2.6 Configure Security Group
    2.7 Review Instance Launch
3. Select or create a key pair
4. Launch the instance
5. Connect to the instance
6. Configure PostgreSQL (.ssh/config)
7. Install PostgreSQL
8. Login to PostgreSQL
9. PostgreSQL authentication with the server
10. Create the server using ec2-54-xxx-xxx-xxx.compute-1.amazonaws.com public DNS
11. Connect and create a database

### Video Tutorial
[AWS Postgres Tutorial](https://www.youtube.com/watch?v=LV2ooRnZqpg)
[Configurations](https://www.youtube.com/watch?v=-UAsEKkh9i8)




