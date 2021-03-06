param([switch]$clear = $false, [switch]$log = $false, [string]$version = "v1.8.0")
$lokacija = (Get-Item -Path ".\" -Verbose).FullName
cd C:
if($clear){
    Write-Host "BRISANJE STARIH VERZIJ"
    minikube delete
    Remove-Item C:\USers\nikpi\.kube -Recurse -Force
    Remove-Item C:\Users\nikpi\.minikube -Recurse -Force
}
if($log){
    minikube start --vm-driver hyperv --hyperv-virtual-switch=Minikube --kubernetes-version=$version --v=9
}
else{
    minikube start --vm-driver hyperv --hyperv-virtual-switch=Minikube --kubernetes-version=$version
}
cd $lokacija