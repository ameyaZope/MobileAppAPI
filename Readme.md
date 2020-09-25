# APIs for Mobile Apps

This project contains the general APIs that a mobile app might need. 
The aim of this project is to create a set of basic APIs that every mobile app needs.You can simply run this project using the embedded tomcat server on any hardware that supports java.

## Usage Guide



## Database APIs



### How to Create REST API usin spring-boot
Below are the steps to create an API with spring boot
1. Create a class and annotate it with @RestConotroller annotation.
This tells spring that if there is a call to REST API, it can look here for the 
API implementations. You can choose to annotate the entire with @RequestMapping("/some/url/").
This tells spring that all the APIs starting with /some/url path are inside this class

2. Now you can simply create a function inside the above mentioned class and annotate it with
@RequestMapping(/further/url). This will tell the spring that any GET call to the URL 
"/some/url/further/url" API will be directed to this function. You can change the request type 
to POST or any other HTTP request type using the @RequestMapping annotation.

3. Since a DB might generally be required to fetch some data for the API response 
below are the steps to connect to mongoDB and use default API provided by spring.
    a. Create a Document (In this case it is the User Class) and annotate it with @
    b. Create a Repository (In this case it is the UserRepository interface) 
    and inherit from the MongoRepository<S,T> interface. 
    c. Start adding APIs inside the interface created above. Some example APIs are
        * Optional<User> findUserByName(final String name)
        * Optional<User> findUserByNameAndEmail(final String name, final String email)
        * List<User> deleteUserByName(final String name)
        * List<User> deleteUserByNameAndEmail(final String name, final String email)
You can choose to implement these functions but a default implementation is generally provided,
so that effort can be saved. By default you dont need to provide implementation, only write the
function declaration inside the interface.

4. To use the above created API interface create a dummy variable of the repository 
interface and annotate that particular variable with @autowired annotation allowing 
spring to put in the implementation of that particular interface at runtime.

5. Now simply use the API created using normal function calls to the dummy variable of
the repository