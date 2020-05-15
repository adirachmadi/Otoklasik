package com.example.basemvp.dummy

import com.example.basemvp.model.Barang

object DataBarang {

    private val Nama = arrayOf(
        "C70 Mulus Terawat",
        "Motor GL Pro Tahun 2000 Pajak Hidup",
        "Motor Mulus C700 Tahun 1981 kondisi bahan",
        "Ducks Garage, Terima Service, Restorasi"
    )

    private val Tanggal = arrayOf(
        "10-11-2019",
        "10-11-2202",
        "10-11-2202",
        "10-11-2020",
        "10-11-2012"
    )


    private val Harga = arrayOf(
        "Rp 7.600.000",
        "Rp 10.000.000",
        "Rp 3.000.000",
        "Rp 100.000",
        "Rp 5.000.000"
    )

    private val Lokasi = arrayOf(
        "Kota Bandar Lampung",
        "Kota Bandar Lampung",
        "Kab. Pringsewu",
        "Kab. Pringsewu",
        "Kota Bandar Lampung"
    )

    private val Penjual = arrayOf(
        "Dani Cell",
        "MV Counter",
        "MV Counter",
        "KNPL Bandar Lampung",
        "MV Counter"
    )

    private val Photo = arrayOf(
        "https://1.bp.blogspot.com/-JL1HPRZpziQ/XrkMSkQm_8I/AAAAAAAAALs/V5Jx8zpcJuoBM_JbMboMw-6yZBunCow3gCK4BGAsYHg/s320/WhatsApp%2BImage%2B2020-05-10%2Bat%2B12.39.27.jpeg",
        "https://1.bp.blogspot.com/-LUiXRv2F8Ik/XrkNmHpxlxI/AAAAAAAAAMA/r61TiUG6fQIMTIR4fUYvfoycmPJKHs9SQCK4BGAsYHg/WhatsApp%2BImage%2B2020-05-10%2Bat%2B12.39.27%2B%25281%2529.jpeg",
        "https://i2.wp.com/zonabikers.com/wp-content/uploads/2016/03/Honda-C700-1981-12.png?fit=800%2C533&ssl=1",
        "https://imgx.gridoto.com/crop/0x0:1280x640/700x465/filters:watermark(file/2017/gridoto/img/watermark_otomotifnet.png,5,5,60)/photo/2020/01/10/1914736123.jpeg",
        "https://imgx.gridoto.com/crop/0x0:1280x640/700x465/filters:watermark(file/2017/gridoto/img/watermark_otomotifnet.png,5,5,60)/photo/2020/01/10/1914736123.jpeg"
        )


    val listBarang: ArrayList<Barang>
        get() {
            val list = arrayListOf<Barang>()
            for (position in Nama.indices) {
                val barang =
                    Barang()
                barang.nama = Nama[position]
                barang.tanggal = Tanggal[position]
                barang.harga = Harga[position]
                barang.lokasi = Lokasi[position]
                barang.penjual = Penjual[position]
                barang.photo = Photo[position]
                list.add(barang)
            }
            return list
        }


}