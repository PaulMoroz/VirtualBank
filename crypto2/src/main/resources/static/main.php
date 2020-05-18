<? 

	/**
	 *  
	 */
	class DBconfig 
	{
		$host = "";;
		$username = "";
		$password = "";	
		$connect = "";
		public function __construct($host,$username,$password)
		{
			$this->host = $host;
			$this->username = $username;
			$this->password = $password;
		}
	}
	class DB
	{
		DBconfig $config = "";
		$conn = "";
		public function __construct($config){
			$this->config = $config;
			$conn = mysql_connect($);
		}
		
	}

	class User
	{

	}

	class UserIn 
	{
		public function register($value='')
		{
			
		}

		public function login($value='')
		{
			# code...
		}
	}
	
	class UserManip
	{
		public function 
	}

	
?>