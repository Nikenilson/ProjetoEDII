using Android.App;
using Android.Widget;
using Android.OS;
using Android.Content;

namespace PathBetweenCititesV2
{
    [Activity(Label = "PathBetweenCititesV2", MainLauncher = true)]
    public class MainActivity : Activity
    {
        Button btnAddCidade;
        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);

            // Set our view from the "main" layout resource
            SetContentView(Resource.Layout.Main);

            btnAddCidade = FindViewById<Button>(Resource.Id.btnAddCidade);
            btnAddCidade.Click += delegate
            {
                var intent = new Intent(this, typeof(AdicionarActivity));
                StartActivity(intent);
            };
            
        }

    }
}

