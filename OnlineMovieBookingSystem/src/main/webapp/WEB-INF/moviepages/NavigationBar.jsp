<nav class="navbar navbar-expand-lg navbar-dark bg-secondary" >
  <a class="navbar-brand px-3 pl-3  text-white" href="#">Admin</a>
  
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link px-3 text-white" href="adminLoginView">Home</a>
     <!--  <a class="nav-item nav-link px-3 text-white" href="endsession">Logout</a> -->
    </div>
    <div class="dropdown px-3">
  <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Movie
  </a>

  <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
    <a class="dropdown-item" href="addMovie">Add Movie</a>
    <a class="dropdown-item" href="removeMovie">Remove Movie</a>
    <a class="dropdown-item" href="showMovies">Show All Movies</a>
  </div>
</div>

<div class="dropdown px-3">
  <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Theatres
  </a>

  <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
    <a class="dropdown-item" href="addTheatre">Add Theatre</a>
    <a class="dropdown-item" href="removeTheatre">Remove Theatre</a>
    <a class="dropdown-item" href="showTheatre">Show All Theatres</a>
  </div>
</div>

<div class="dropdown px-3">
  <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Shows
  </a>

  <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
    <a class="dropdown-item" href="addShow">Add Show</a>
    <a class="dropdown-item" href="removeShow">Remove Show</a>
    <a class="dropdown-item" href="updateShow">Update Shows</a>
    <a class="dropdown-item" href="showAllShows">All Shows</a>
  </div>
</div>
 <a class="nav-item nav-link px-3 text-white" href="endsession">Logout</a>

  </div>
</nav>